package it.senape.wldiag.service.internal.Impl;

import it.senape.wldiag.jpa.model.jta.InternalThread;
import it.senape.wldiag.jpa.repository.InternalThreadRepository;
import it.senape.wldiag.service.internal.InternalThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by michele.arciprete on 10-Jan-18.
 */
@Service
public class InternalThreadServiceImpl implements InternalThreadService {

    private InternalThreadRepository internalThreadRepository;

    @Autowired
    public InternalThreadServiceImpl(InternalThreadRepository internalThreadRepository) {
        this.internalThreadRepository = internalThreadRepository;
    }

    @Override
    @Transactional
    public InternalThread save(String activeThread) {
        System.out.println("Saving active thread: " + activeThread);
        if(activeThread!=null &&
                activeThread.matches("^Thread\\[.*\\]")) {
//            Pattern pattern = Pattern.compile("^Thread\\[([\\w\\[\\s\\]]+),(\\w+),([\\w\\s]+)\\]");
//            Matcher matcher = pattern.matcher(activeThread);
//            while (matcher.find()) {
//                String name = matcher.group(1);
//                String type = matcher.group(3);
//
//                InternalThread internalThread = internalThreadRepository.findByNameAndType(name, type);
//                if (internalThread == null) {
//                    internalThread = new InternalThread();
//                }
//                internalThread.setName(name);
//                internalThread.setPoolNumber(Integer.parseInt(matcher.group(2)));
//                internalThread.setType(type);
//                return internalThreadRepository.save(internalThread);
//            }
            Pattern pattern = Pattern.compile("^Thread\\[(.*)\\]");
            Matcher matcher = pattern.matcher(activeThread);
            while (matcher.find()) {
                String thread = matcher.group(1);
                String[] elements = thread.split(",");
                String name = elements[0];
                String poolNumber = elements[1];
                String type = elements[2];
                InternalThread internalThread = internalThreadRepository.findByNameAndType(name, type);
                if (internalThread == null) {
                    internalThread = new InternalThread();
                }
                internalThread.setName(name);
                internalThread.setPoolNumber(Integer.parseInt(poolNumber));
                internalThread.setType(type);
                return internalThreadRepository.save(internalThread);
            }
        }
        System.out.println("Cannot match active thread name pattern");
        return null;
    }
}
