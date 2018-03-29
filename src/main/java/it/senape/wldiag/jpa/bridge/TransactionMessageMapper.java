package it.senape.wldiag.jpa.bridge;

import it.senape.wldiag.dto.EjbTransactionPropertyDto;
import it.senape.wldiag.dto.InternalThreadDto;
import it.senape.wldiag.dto.PropertyDto;
import it.senape.wldiag.dto.ResourceDto;
import it.senape.wldiag.jpa.model.jta.EjbTransactionProperty;
import it.senape.wldiag.jpa.model.jta.InternalThread;
import it.senape.wldiag.jpa.model.jta.Transaction;
import it.senape.wldiag.message.TransactionsMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a mapper class that is used to transform {@link Transaction} objects
 * into {@link TransactionsMessage} objects.
 * Created by michele.arciprete on 18-Dec-17.
 */
public final class TransactionMessageMapper {

    /**
     * Transforms the list of {@link Transaction} objects given as a method parameter
     * into a list of {@link TransactionsMessage} objects and returns the created list.
     *
     * @param entities
     * @return
     */
    public static List<TransactionsMessage> mapEntitiesIntoDTOs(Iterable<Transaction> entities) {
        List<TransactionsMessage> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(mapEntityIntoDTO(e)));
        return dtos;
    }

    /**
     * Transforms the {@link Transaction} object given as a method parameter into a
     * {@link TransactionsMessage} object and returns the created object.
     *
     * @param entity
     * @return
     */
    public static TransactionsMessage mapEntityIntoDTO(Transaction entity) {
        TransactionsMessage dto = new TransactionsMessage();

        dto.setXid(entity.getXid());
        dto.setState(entity.getState());
        dto.setStatus(entity.getStatus());
        dto.setBeginTime(entity.getBeginTime());
        dto.setCoordinatorURL(entity.getCoordinatorURL());
        dto.setOwnerTM(entity.getOwnerTM());


        InternalThreadDto activeThread = new InternalThreadDto();
        InternalThread internalThread = entity.getActiveThread();
        if (internalThread!=null) {
            activeThread.setId(internalThread.getId());
            activeThread.setName(internalThread.getName());
            activeThread.setPoolNumber(internalThread.getPoolNumber());
            activeThread.setType(internalThread.getType());
            dto.setActiveThread(activeThread);
        } else {
            System.out.println("ERROR INTERNAL THREAD NULL!!!!!");
        }

        dto.setRepliesOwedMe(entity.getRepliesOwedMe());
        dto.setRepliesOwedOthers(entity.getRepliesOwedOthers());
        dto.setRetry(entity.isRetry());

        if(!entity.getLocalProperties().isEmpty()) {
            entity.getLocalProperties().forEach( prop -> {

                PropertyDto propertyDTO = new PropertyDto();
                propertyDTO.setName(prop.getName());
                propertyDTO.setValue(prop.getValue());
                dto.getGlobalProperties().add(propertyDTO);

                if (prop instanceof EjbTransactionProperty) {
                    EjbTransactionPropertyDto ejbTransactionDTO = new EjbTransactionPropertyDto();
                    EjbTransactionProperty ejbTx = (EjbTransactionProperty) prop;
                    ejbTransactionDTO.setId(ejbTx.getId());
                    ejbTransactionDTO.setClassName(ejbTx.getClassName());
                    ejbTransactionDTO.setMethod(ejbTx.getMethod());
                    ejbTransactionDTO.setArguments(ejbTx.getArguments());
                    dto.getEjbTransactions().add(ejbTransactionDTO);
                }
            });
        }

        if(!entity.getGlobalProperties().isEmpty()) {
            entity.getGlobalProperties().forEach( prop -> {
                PropertyDto propertyDTO = new PropertyDto();
                propertyDTO.setName(prop.getName());
                propertyDTO.setValue(prop.getValue());
                dto.getGlobalProperties().add(propertyDTO);
            });
        }

        if (!entity.getResources().isEmpty()) {
            entity.getResources().forEach( resource -> {
                ResourceDto resourceDTO = new ResourceDto();
                resourceDTO.setBusy(resource.isBusy());
                resourceDTO.setName(resource.getName());
                resourceDTO.setState(resource.getState());
                resourceDTO.setXid(resource.getXid());
                dto.getResources().add(resourceDTO);
            });
        }

        //TODO: Servers

        return dto;
    }


    /**
     * Transforms {@code Page<ENTITY>} objects into {@code Page<DTO>} objects.
     *
     * @param pageRequest The information of the requested page.
     * @param source      The {@code Page<ENTITY>} object.
     * @return The created {@code Page<DTO>} object.
     */
    public static Page<TransactionsMessage> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<Transaction> source) {
        List<TransactionsMessage> dtos = mapEntitiesIntoDTOs(source.getContent());
        return new PageImpl<>(dtos, pageRequest, source.getTotalElements());
    }
}
