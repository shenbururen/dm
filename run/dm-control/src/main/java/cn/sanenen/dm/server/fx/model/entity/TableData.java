package cn.sanenen.dm.server.fx.model.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

/**
 * @author sun
 **/
public class TableData {
    private SimpleStringProperty ip = new SimpleStringProperty();
    private SimpleIntegerProperty port = new SimpleIntegerProperty();
    private SimpleStringProperty version = new SimpleStringProperty();
    private SimpleStringProperty status = new SimpleStringProperty();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableData tableData = (TableData) o;
        return Objects.equals(ip.get(), tableData.ip.get());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ip.get());
    }

    public String getIp() {
        return ip.get();
    }

    public SimpleStringProperty ipProperty() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip.set(ip);
    }

    public String getVersion() {
        return version.get();
    }

    public SimpleStringProperty versionProperty() {
        return version;
    }

    public void setVersion(String version) {
        this.version.set(version);
    }

    public int getPort() {
        return port.get();
    }

    public SimpleIntegerProperty portProperty() {
        return port;
    }

    public void setPort(int port) {
        this.port.set(port);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
