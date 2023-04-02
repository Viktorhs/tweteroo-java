package com.twetero.api.dto;

import jakarta.validation.constraints.NotBlank;

public record UsersDTO(

                @NotBlank String username,
                @NotBlank String avatar

) {

}
