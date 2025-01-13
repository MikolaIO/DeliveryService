package com.solvd.deliveryservice.people.employees;

import com.solvd.deliveryservice.request.DeliveryRequest;
import com.solvd.deliveryservice.storage.Storage;

public interface ICollector {
    void storeRequestPackage(Storage storage, DeliveryRequest request);

    void giveCourier(Storage storage, DeliveryRequest request, Courier courier);
}
