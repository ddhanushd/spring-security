package com.investor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "investors")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Investors {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int investorId;

	    @NotBlank(message = "Investor name must not be blank")
	    private String investorName;

	    @NotBlank(message = "Username must not be blank")
	    private String username;

	    @NotBlank(message = "Password must not be blank")
	    private String password;

	    @NotNull(message = "Phone number must not be null")
	    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
	    private String investorPhoneno;

	    @NotBlank(message = "Email must not be blank")
	    @Email(message = "Email should be valid")
	    private String investorEmail;

	    @NotBlank(message = "Address must not be blank")
	    private String investorAddress;
	    
	    private String role;
}
