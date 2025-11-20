package yk.projects.springboottesting.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long customerId) {
        super(String.format("Customer with id %d is not present", customerId));
    }
}
