package com.cd.zuul.ywdp.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by li.mingyang on 2018/4/29.
 */
public class ResponseFilter extends ZuulFilter{


    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletResponse response = context.getResponse();
        Long length = context.getOriginContentLength();

        if (!StringUtils.isEmpty(length)) {
            response.setContentLengthLong(length);
        }
        return null;
    }


}
