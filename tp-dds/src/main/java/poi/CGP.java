package poi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Address;
import domain.Coordinate;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

@Entity
@Table(name = "cgp")
public class CGP extends Poi {
public CGP() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(CGP.class);

    @Column(name = "communeRadius")
    private double communeRadius;


    @OneToMany(cascade = CascadeType.ALL)
    private List<CGPService> services;

    public CGP(String name, Address address, Coordinate coordinate, double communeRadius,
               List<CGPService> services) {
        super(name, address, coordinate);
        this.type = this.getClass().getSimpleName();
        this.communeRadius = communeRadius;
        this.services = services;
        this.getData().add(this.getName());
        for (CGPService cgpService : services) {
            this.getData().add(cgpService.getServiceName());
        }
        this.getData().add("cgp");
        for (CGPService cgpService : services) {
            this.getData().add(cgpService.getServiceName());
        }
        icon = "cgp";

    }


    public double getCommuneRadius() {
        return communeRadius;
    }

    public void setCommuneRadius(double communeRadius) {
        this.communeRadius = communeRadius;
    }

    public List<CGPService> getServices() {
        return services;
    }

    public void setServices(ArrayList<CGPService> services) {
        this.services = services;
    }

    @Override
    public boolean isNearby(Coordinate coordinate) throws ClientProtocolException, IOException {
        double distance = this.getGoogleService().getDistance(coordinate, this.getCoordinate());
        return distance < communeRadius;
    }

    @Override
    public String getType() {
        return "CGP";
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public boolean isAvailable() {
        Date date = new Date();
        for (CGPService cgpService : services) {
            if (cgpService.isAvailable(date, this.getAvailabilityService())) {
                return true;
            }
        }
        return false;
    }

    public boolean isAvailable(String serviceName) {
        Date date = new Date();
        if (!(this.getServices().isEmpty())) {
            for (CGPService currentCGPService : services) {
                if (currentCGPService.getServiceName().equals(serviceName)) {
                    LOGGER.info(currentCGPService.getServiceName());
                    return currentCGPService.isAvailable(date, this.getAvailabilityService());
                }
            }
        }
        return false;
    }

    public void addService(CGPService cgpService) {
        services.add(cgpService);
    }

}
