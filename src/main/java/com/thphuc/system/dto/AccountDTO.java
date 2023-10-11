package com.thphuc.system.dto;

import com.thphuc.system.model.Campus;
import com.thphuc.system.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDTO {
    private int accountID;
    private String username;
    private Role role;
    private Campus campus;
}
