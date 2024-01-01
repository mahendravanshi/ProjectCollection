    package com.stream;

    import java.util.Objects;

    public class Emp {

        private int id;
        private String department;
        private String name;

        public Emp(int id, String department, String name) {
            this.id = id;
            this.department = department;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Emp emp = (Emp) o;
            return id == emp.id && Objects.equals(department, emp.department) && Objects.equals(name, emp.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, department, name);
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "id=" + id +
                    ", department='" + department + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }



    }
