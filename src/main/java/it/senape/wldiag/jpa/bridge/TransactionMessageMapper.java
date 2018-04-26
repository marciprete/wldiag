package it.senape.wldiag.jpa.bridge;

import it.senape.wldiag.dto.EjbTransactionPropertyDto;
import it.senape.wldiag.dto.InternalThreadDto;
import it.senape.wldiag.dto.PropertyDto;
import it.senape.wldiag.dto.ResourceDto;
import it.senape.wldiag.jpa.model.jta.EjbTransactionProperty;
import it.senape.wldiag.jpa.model.jta.InternalThread;
import it.senape.wldiag.jpa.model.jta.Transaction;
import it.senape.wldiag.jpa.projection.TransactionProjection;
import it.senape.wldiag.message.TransactionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a mapper class that is used to transform {@link Transaction} objects
 * into {@link TransactionMessage} objects.
 * Created by michele.arciprete on 18-Dec-17.
 */
public final class TransactionMessageMapper {

    private static final Logger logger = LoggerFactory.getLogger(TransactionMessageMapper.class);

    private TransactionMessageMapper() {}

    /**
     * Transforms the list of {@link Transaction} objects given as a method parameter
     * into a list of {@link TransactionMessage} objects and returns the created list.
     *
     * @param entities
     * @return
     */
    public static List<TransactionMessage> mapEntitiesIntoDTOs(Iterable<Transaction> entities) {
        List<TransactionMessage> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(mapEntityIntoDTO(e)));
        return dtos;
    }

    /**
     * Transforms the {@link Transaction} object given as a method parameter into a
     * {@link TransactionMessage} object and returns the created object.
     *
     * @param entity
     * @return
     */
    public static TransactionMessage mapEntityIntoDTO(Transaction entity) {
        TransactionMessage dto = new TransactionMessage();

        dto.setXid(entity.getXid());
        dto.setState(entity.getState());
        dto.setStatus(entity.getStatus());
        dto.setBeginTime(entity.getBeginTime());
        dto.setCoordinatorURL(entity.getCoordinatorURL());
        dto.setOwnerTM(entity.getOwnerTM());

        InternalThreadDto activeThread = new InternalThreadDto();
        InternalThread internalThread = entity.getActiveThread();
        if (internalThread != null) {
            activeThread.setId(internalThread.getId());
            activeThread.setName(internalThread.getName());
            activeThread.setPoolNumber(internalThread.getPoolNumber());
            activeThread.setType(internalThread.getType());
            dto.setActiveThread(activeThread);
        } else {
            logger.error("Internal Thread is null");
        }

        dto.setRepliesOwedMe(entity.getRepliesOwedMe());
        dto.setRepliesOwedOthers(entity.getRepliesOwedOthers());
        dto.setRetry(entity.isRetry());

        if (!entity.getLocalProperties().isEmpty()) {
            entity.getLocalProperties().forEach(prop -> {

                PropertyDto propertyDTO = new PropertyDto();
                propertyDTO.setName(prop.getName());
                propertyDTO.setValue(prop.getValue());
                dto.getGlobalProperties().add(propertyDTO);

                if (prop instanceof EjbTransactionProperty) {
                    EjbTransactionPropertyDto ejbTransactionDTO = new EjbTransactionPropertyDto();
                    EjbTransactionProperty ejbTx = (EjbTransactionProperty) prop;
                    ejbTransactionDTO.setId(ejbTx.getId());
                    String className = ejbTx.getClassName();
                    ejbTransactionDTO.setFqnClassName(className);
                    ejbTransactionDTO.setSimpleClassName(className.substring(className.lastIndexOf('.')));
                    ejbTransactionDTO.setMethod(ejbTx.getMethod());
                    ejbTransactionDTO.setArguments(ejbTx.getArguments());
                    dto.getEjbTransactions().add(ejbTransactionDTO);
                }
            });
        }

        if (!entity.getGlobalProperties().isEmpty()) {
            entity.getGlobalProperties().forEach(prop -> {
                PropertyDto propertyDTO = new PropertyDto();
                propertyDTO.setName(prop.getName());
                propertyDTO.setValue(prop.getValue());
                dto.getGlobalProperties().add(propertyDTO);
            });
        }

        if (!entity.getResources().isEmpty()) {
            entity.getResources().forEach(resource -> {
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
    public static Page<TransactionMessage> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<Transaction> source) {
        List<TransactionMessage> dtos = mapEntitiesIntoDTOs(source.getContent());
        return new PageImpl<>(dtos, pageRequest, source.getTotalElements());
    }

    public static Page<TransactionMessage> mapProjectionPageIntoDTOPage(Page<TransactionProjection> source, Pageable pageRequest) {
        List<TransactionMessage> dtos = mapProjectionsIntoDTOs(source.getContent());
        return new PageImpl<>(dtos, pageRequest, source.getTotalElements());
    }

    private static List<TransactionMessage> mapProjectionsIntoDTOs(List<TransactionProjection> content) {
        List<TransactionMessage> dtos = new ArrayList<>();
        content.forEach(e -> dtos.add(mapProjectionIntoDTO(e)));
        return dtos;
    }

    private static TransactionMessage mapProjectionIntoDTO(TransactionProjection projection) {
        TransactionMessage message = new TransactionMessage();
        message.setXid(projection.getXID());
        message.setBeginTime(projection.getBeginTime());
        message.setStatus(projection.getStatus());
        message.setThreadName(projection.getThreadName());
        message.setWlsStatus(projection.getWlsStatus());
        message.setEjbTransactionSignature(projection.getEjbTransactionSignature());
        return message;
    }
}
