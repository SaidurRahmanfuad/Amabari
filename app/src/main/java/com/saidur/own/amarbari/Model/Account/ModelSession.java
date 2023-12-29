package com.saidur.own.amarbari.Model.Account;

public class ModelSession {
      String name;
      String mobile;
      String ide;
      String updated_at;
      String created_at;
      int empid;
      int role;

      public ModelSession() {
      }

      public ModelSession(String name, String mobile, String ide, String updated_at, String created_at, int empid, int role) {
            this.name = name;
            this.mobile = mobile;
            this.ide = ide;
            this.updated_at = updated_at;
            this.created_at = created_at;
            this.empid = empid;
            this.role = role;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public String getMobile() {
            return mobile;
      }

      public void setMobile(String mobile) {
            this.mobile = mobile;
      }

      public String getIde() {
            return ide;
      }

      public void setIde(String ide) {
            this.ide = ide;
      }

      public String getUpdated_at() {
            return updated_at;
      }

      public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
      }

      public String getCreated_at() {
            return created_at;
      }

      public void setCreated_at(String created_at) {
            this.created_at = created_at;
      }

      public int getEmpid() {
            return empid;
      }

      public void setEmpid(int empid) {
            this.empid = empid;
      }

      public int getRole() {
            return role;
      }

      public void setRole(int role) {
            this.role = role;
      }
}
