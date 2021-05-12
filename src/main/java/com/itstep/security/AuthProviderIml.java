package com.itstep.security;

import com.itstep.model.Student;
import com.itstep.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;


@Component
public class AuthProviderIml implements AuthenticationProvider {

    private StudentRepo studentRepo;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String phone = authentication.getName();
        Student student = studentRepo.findByPhone(phone);

        if(student == null){
            throw new UsernameNotFoundException("Student not found");
        }

        String password = authentication.getCredentials().toString();


        if(!passwordEncoder.matches(password, student.getPassword())){
            //if(!password.equals(student.getPassword())){
            System.out.println("Password is wrong");
            throw new BadCredentialsException("Пароль не верный");
        }
        List<GrantedAuthority>authorityList = new ArrayList<>();

        return new UsernamePasswordAuthenticationToken(student, null, authorityList);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
