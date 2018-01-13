package pojos;

import java.util.Calendar;
import java.util.Date;

public class Customer {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final Date dateOfBirth;
    private final String billingAndress;
    private final String deliveryAddress;
    private final boolean deliveryAddressBillingAddress;

    private Customer(long id, String firstName, String lastName, Date dateOfBirth, String billingAndress, String deliveryAddress, boolean deliveryAddressBillingAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.billingAndress = billingAndress;
        this.deliveryAddress = deliveryAddress;
        this.deliveryAddressBillingAddress = deliveryAddressBillingAddress;
    }

    static class Builder{
        private  long id;
        private  String firstName;
        private  String lastName;
        private  Date dateOfBirth;
        private  String billingAdress;
        private  String deliveryAddress;
        private  boolean deliveryAddressBillingAddress;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder dateOfBirth(Date dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder billingAdress(String billingAdress){
            this.billingAdress = billingAdress;
            return this;
        }

        public Builder deliveryAddress(String deliveryAddress){
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder deliveryAddressBillingAddress(boolean deliveryAddressBillingAddress){
            this.deliveryAddressBillingAddress = deliveryAddressBillingAddress;
            return this;
        }

        public Customer build(){
            validate();
            return new Customer(id,firstName,lastName,dateOfBirth,billingAdress,deliveryAddress,deliveryAddressBillingAddress);
        }

        private void validate() {
            if(id < 0){
                throw new IllegalStateException("ID must be positive");
            }
            if(firstName.length() > 100){
                throw new IllegalStateException("First name must be under 100");
            }
            if(lastName.length() >100){
                throw new IllegalStateException("Last name must be under 100");
            }
            Calendar dateOfBirthCalendar = Calendar.getInstance();
            dateOfBirthCalendar.setTime(dateOfBirth);
            Calendar validDateOfBirth = Calendar.getInstance();
            validDateOfBirth.add(Calendar.YEAR, -18);
            if(dateOfBirthCalendar.before(validDateOfBirth)){
                throw new IllegalStateException("Above 18 years old,Use the website");
            }
        }

    }
}
