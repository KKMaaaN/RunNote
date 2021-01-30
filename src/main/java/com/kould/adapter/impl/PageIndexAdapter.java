package com.kould.adapter.impl;

import com.kould.adapter.IPageAdapter;
import org.springframework.stereotype.Component;

@Component
public class PageIndexAdapter implements IPageAdapter {
    public int indexBeStart(int index,int stepSize) {
        return index*stepSize-stepSize ;
    }
}
