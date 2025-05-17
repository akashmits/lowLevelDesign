package com.lld.lowleveldesign.solidPrincipal.interfacesegregation;

//Picture an ATM, which has a screen where we wish to display different messages. If you want to add
// a messages on the ATM that appears only for withdrawal functionality, how would u solve it
public interface Messenger {
    public void askForCard();
    public void tellInvalidCard();
    public void askForPin();
    public void tellInvalidPin();
    public void tellCardWasSeized();
    public void askForAccount();
    public void tellNotEnoughMoneyInAccount();
    public void tellAmountDeposited();
    public void tellBalance();

    // Instead, split the messanger interface up so that different ATM funcionality depend on seperate Messanger
}
