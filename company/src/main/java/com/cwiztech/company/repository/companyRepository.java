package com.cwiztech.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cwiztech.company.model.Company;


public interface companyRepository extends JpaRepository<Company, Long> {
	@Query(value = "select * from TBLCOMPANY where ISACTIVE='Y'", nativeQuery = true)
	public List<Company> findActive();
	
	@Query(value = "select * from TBLCOMPANY "
			+ "where COMPANY_NAME like ?1 or COMPANY_DESC like ?1 and ISACTIVE='Y'", nativeQuery = true)
	public List<Company> findBySearch(String search);

	@Query(value = "select * from TBLCOMPANY "
			+ "where COMPANY_NAME like ?1 or COMPANY_DESC like ?1 ", nativeQuery = true)
	public List<Company> findAllBySearch(String search);

	@Query(value = "select * from TBLCOMPANY " 
			+ "where COMPANYSUBTYPE_ID LIKE CASE WHEN ?1 = 0 THEN COMPANYSUBTYPE_ID ELSE ?1 END "
			+ "and (COMPANYPARENT_ID LIKE CASE WHEN ?2 = 0 THEN COMPANYPARENT_ID ELSE ?2 END or COMPANYPARENT_ID  is NULL) "
			+ "and COMPANYSTATUS_ID LIKE CASE WHEN ?3 = 0 THEN COMPANYSTATUS_ID ELSE ?3 END "
			+ "and BUSINESSNATURE_ID LIKE CASE WHEN ?4 = 0 THEN BUSINESSNATURE_ID ELSE ?4 END "
			+ "and ISACTIVE='Y'", nativeQuery = true)
	List<Company> findByAdvancedSearch(Long companysubtypeID,Long companyparent_ID,Long companystatus_ID,Long businessnature_ID);

	@Query(value = "select * from TBLCOMPANY " 
			+ "where COMPANYSUBTYPE_ID LIKE CASE WHEN ?1 = 0 THEN COMPANYSUBTYPE_ID ELSE ?1 END "
			+ "and (COMPANYPARENT_ID LIKE CASE WHEN ?2 = 0 THEN COMPANYPARENT_ID ELSE ?2 END or COMPANYPARENT_ID  is NULL) "
			+ "and COMPANYSTATUS_ID LIKE CASE WHEN ?3 = 0 THEN COMPANYSTATUS_ID ELSE ?3 END "
			+ "and BUSINESSNATURE_ID LIKE CASE WHEN ?4 = 0 THEN BUSINESSNATURE_ID ELSE ?4 END ", nativeQuery = true)
	List<Company> findAllByAdvancedSearch(Long companysubtypeID,Long companyparent_ID,Long companystatus_ID,Long businessnature_ID);

}
