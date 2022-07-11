package com.finco.framework;

import com.finco.framework.command.FincoOperationManager;

public class Framework {

    private FincoOperationManager fincoOperationManager;

    private FincoReceiver fincoReceiver;

    public Framework(FincoOperationManager fincoOperationManager, FincoReceiver fincoReceiver){
        this.fincoOperationManager = fincoOperationManager;
        this.fincoReceiver = fincoReceiver;
    }

    public FincoReceiver getFincoReceiver() {
        return fincoReceiver;
    }

    public FincoOperationManager getFincoOperationManager() {
        return fincoOperationManager;
    }
}
