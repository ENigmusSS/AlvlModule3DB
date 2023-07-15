package ua.golovchenko.phoneoperator.repo;

import ua.golovchenko.phoneoperator.entities.SMS;

import java.util.List;

public interface SMSRepository extends GenericRepository<SMS>{
    List<SMS> searchBySignature(String signature);
}
