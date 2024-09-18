package org.example.wallet.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.wallet.template.IdNotes;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "category_tables")
public class Categories extends IdNotes {

    private String categoryName;
    private String categoriyDescription;

    @ManyToOne
    private Categories parentCategory;

    @ManyToOne
    private UserNotes userNotes;
}
