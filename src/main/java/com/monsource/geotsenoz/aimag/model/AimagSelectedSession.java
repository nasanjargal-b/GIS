package com.monsource.geotsenoz.aimag.model;

import com.monsource.geotsenoz.aimag.model.Aimag;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by nyamaa on 6/16/14.
 */
public class AimagSelectedSession implements Serializable{
    private Aimag aimag;

    public Aimag getAimag() {
        return aimag;
    }

    public void setAimag(Aimag aimag) {
        this.aimag = aimag;
    }

    public AimagSelectedSession() {
    }

}
