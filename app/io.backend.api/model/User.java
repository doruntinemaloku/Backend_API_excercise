package io.backend.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseModel{

    @NotEmpty
    @Size(min = 2, message = "There should be at least two characters")
    String username;

    @NotEmpty
    @Size(min = 6, message = "There should be at least six characters")
    String password;

    List<String> roles = new ArrayList<>();
}
