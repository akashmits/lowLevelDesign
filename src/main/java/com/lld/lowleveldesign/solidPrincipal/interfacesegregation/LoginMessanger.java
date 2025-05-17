package com.lld.lowleveldesign.solidPrincipal.interfacesegregation;

public interface LoginMessanger{
    public void askForCard();
    public void tellInvalidCard();
    public void askForPin();
    public void tellInvalidPin();
}