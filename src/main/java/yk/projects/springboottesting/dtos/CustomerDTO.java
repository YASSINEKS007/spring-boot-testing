package yk.projects.springboottesting.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDTO {

    private Long id;

    private String name;

    private String email;
}
