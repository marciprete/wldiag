package it.senape.wldiag.config;

import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;

public class WebTestConfig {

    /**
     * This method returns a {@link org.springframework.web.method.support.HandlerMethodArgumentResolver} that can
     * construct {@link org.springframework.data.domain.Sort} objects by using the request params of the
     * incoming request.
     * @return
     */
    public static SortHandlerMethodArgumentResolver sortArgumentResolver() {
        return new SortHandlerMethodArgumentResolver();
    }

    /**
     * This method returns a {@link org.springframework.web.method.support.HandlerMethodArgumentResolver} that can
     * construct {@link org.springframework.data.domain.Pageable} objects by using the request params of the
     * incoming request.
     * @return
     */
    public static PageableHandlerMethodArgumentResolver pageRequestArgumentResolver() {
        return new PageableHandlerMethodArgumentResolver(sortArgumentResolver());
    }

}
