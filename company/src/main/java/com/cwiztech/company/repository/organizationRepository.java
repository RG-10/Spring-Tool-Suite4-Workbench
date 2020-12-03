package com.cwiztech.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cwiztech.company.model.Organization;


public interface organizationRepository extends JpaRepository<Organization, Long> {
	@Query(value = "select * from TBLORGANIZATION where ISACTIVE='Y'", nativeQuery = true)
	public List<Organization> findActive();
	
	@Query(value = "select * from TBLORGANIZATION "
			+ "where ORGANIZATION_NAME like ?1 or ORGANIZATION_DESC like ?1 and ISACTIVE='Y'", nativeQuery = true)
	public List<Organization> findBySearch(String search);

	@Query(value = "select * from TBLORGANIZATION "
			+ "where ORGANIZATION_NAME like ?1 or ORGANIZATION_DESC like ?1 ", nativeQuery = true)
	public List<Organization> findAllBySearch(String search);

	@Query(value = "select * from TBLORGANIZATION " 
			+ "where ORGANIZATIONTYPE_ID LIKE CASE WHEN ?1 = 0 THEN ORGANIZATIONTYPE_ID ELSE ?1 END "
			+ "and ISACTIVE='Y'", nativeQuery = true)
	List<Organization> findByAdvancedSearch(Long organizationtypeID);
	@Query(value = "select * from TBLORGANIZATION " 
			+ "where ORGANIZATIONTYPE_ID LIKE CASE WHEN ?1 = 0 THEN ORGANIZATIONTYPE_ID ELSE ?1 END "
			, nativeQuery = true)
	List<Organization> findAllByAdvancedSearch(Long organizationtypeID);

}
