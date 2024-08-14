package com.victorhugo.crudjavareact.specification;

import com.victorhugo.crudjavareact.model.Wallet;
import org.springframework.data.jpa.domain.Specification;

public class WalletSpecification {
    public static Specification<Wallet> filterByUserId(Long userId) {
        return (root, query, criteriaBuilder) -> {
            if (userId == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("user").get("id"), userId);
        };
    }
}
