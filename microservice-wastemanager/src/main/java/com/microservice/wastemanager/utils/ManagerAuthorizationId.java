//package com.microservice.wastemanager.utils;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class ManagerAuthorizationId implements Serializable {
//    private Long idWasteManager;
//    private Long idWasteAuthorization;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ManagerAuthorizationId that = (ManagerAuthorizationId) o;
//        if (!Objects.equals(idWasteAuthorization, that.idWasteAuthorization)) {
//            return false;
//        } else return Objects.equals(idWasteManager, that.idWasteManager);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(idWasteManager, idWasteAuthorization);
//    }
//}
