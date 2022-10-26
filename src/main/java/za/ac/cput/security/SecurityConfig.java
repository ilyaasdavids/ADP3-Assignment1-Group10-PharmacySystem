package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Admin")
                .password(encoder().encode("12345"))
                .roles("ADMIN", "USER");
        auth.inMemoryAuthentication()
                .withUser("User")
                .password(encoder().encode("54321"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable();
        http.authorizeRequests()

                //employee
                .antMatchers(HttpMethod.POST, "/PharmacySystem/employee/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/employee/read/").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/employee/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/PharmacySystem/employee/delete/").hasRole("ADMIN")

                //prescription
                .antMatchers(HttpMethod.POST, "/PharmacySystem/prescription/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/prescription/read/").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/prescription/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/PharmacySystem/prescription/delete/").hasRole("ADMIN")

                //CustomerContact
                .antMatchers(HttpMethod.POST, "/PharmacySystem/customerContact/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/customerContact/read/").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/customerContact/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/PharmacySystem/customerContact/delete/").hasRole("ADMIN")

                //Customer
                .antMatchers(HttpMethod.POST, "/PharmacySystem/customer/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/customer/read/").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/customer/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/PharmacySystem/customer/delete/").hasRole("ADMIN")

                //EmployeeContact
                .antMatchers(HttpMethod.POST, "/PharmacySystem/employeeContact/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/employeeContact/read/").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/employeeContact/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/PharmacySystem/employeeContact/delete/").hasRole("ADMIN")

                //Inventory
                .antMatchers(HttpMethod.POST, "/PharmacySystem/inventory/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/inventory/read/").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/inventory/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/PharmacySystem/inventory/delete/").hasRole("ADMIN")

                //Medication
                .antMatchers(HttpMethod.POST, "/PharmacySystem/medication/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/medication/read/").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/medication/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/PharmacySystem/medication/delete/").hasRole("ADMIN")

                //PharmacyContact
                .antMatchers(HttpMethod.POST, "/PharmacySystem/pharmacyContact/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/pharmacyContact/read/").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/pharmacyContact/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/PharmacySystem/pharmacyContact/delete/").hasRole("ADMIN")

                //Pharmacy
                .antMatchers(HttpMethod.POST, "/PharmacySystem/pharmacy/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/pharmacy/read/").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/pharmacy/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/PharmacySystem/pharmacy/delete/").hasRole("ADMIN")

                //Supplier
                .antMatchers(HttpMethod.POST, "/PharmacySystem/supplier/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/supplier/read/").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/supplier/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/PharmacySystem/supplier/delete/").hasRole("ADMIN")

                //SupplierContact
                .antMatchers(HttpMethod.POST, "/PharmacySystem/supplierContact/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/supplierContact/read/").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/supplierContact/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/PharmacySystem/supplierContact/delete/").hasRole("ADMIN")

                .and().formLogin()
                .disable()
                .httpBasic();
    }

    @Bean
    public static BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
