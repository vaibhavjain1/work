package aniket;

import java.util.Date;

class Data {
    String time;

    Date date;
    Double into;
    Double inth;
    Double intl;
    Double intc;
    Double ssboe;
    Double intv;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getInto() {
        return into;
    }

    public void setInto(Double into) {
        this.into = into;
    }

    public Double getInth() {
        return inth;
    }

    public void setInth(Double inth) {
        this.inth = inth;
    }

    public Double getIntl() {
        return intl;
    }

    public void setIntl(Double intl) {
        this.intl = intl;
    }

    public Double getIntc() {
        return intc;
    }

    public void setIntc(Double intc) {
        this.intc = intc;
    }

    public Double getSsboe() {
        return ssboe;
    }

    public void setSsboe(Double ssboe) {
        this.ssboe = ssboe;
    }

    public Double getIntv() {
        return intv;
    }

    public void setIntv(Double intv) {
        this.intv = intv;
    }

    @Override
    public String toString() {
        return "Data{" +
                "Date='" + time + '\'' +
                ", Open=" + into +
                ", High=" + inth +
                ", Low=" + intl +
                ", Close=" + intc +
                ", ssboe=" + ssboe +
                ", Volume=" + intv +
                '}';
    }
}
