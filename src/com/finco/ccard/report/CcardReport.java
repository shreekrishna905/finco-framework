package com.finco.ccard.report;

import com.finco.ccard.account.CcardAccount;
import com.finco.framework.account.entry.Entry;
import com.finco.framework.report.FincoReport;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CcardReport implements FincoReport {

    private CcardAccount ccardAccount;

    public CcardReport(CcardAccount ccardAccount){
        this.ccardAccount = ccardAccount;
    }

    @Override
    public String generate() {
        String entryReport = "";
        for (Entry entry: ccardAccount.getEntries()){
            if(ChronoUnit.DAYS.between(entry.getDate(), LocalDate.now())<=30)
            entryReport+="\n"+entry;
        }
        return entryReport;
    }
}
