public class DependencyInjectionExample {
    interface CustomerRepository {
        String findCustomerById(String customerId);
    }
    static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public String findCustomerById(String customerId) {
            return "Customer[ID=" + customerId + ", Name=Deepthi Aetukuri]";
        }
    }
    static class CustomerService {
        private final CustomerRepository customerRepository;
        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }
        public void displayCustomer(String customerId) {
            String customerDetails = customerRepository.findCustomerById(customerId);
            System.out.println("Customer Details: " + customerDetails);
        }
    }
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);
        service.displayCustomer("6640");
    }
}
