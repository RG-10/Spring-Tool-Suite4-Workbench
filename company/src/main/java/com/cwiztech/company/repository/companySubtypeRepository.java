package com.cwiztech.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cwiztech.company.model.CompanySubtype;


public interface companySubtypeRepository extends JpaRepository<CompanySubtype, Long> {
	@Query(value = "select * from TBLCOMPANYSUBTYPE where ISACTIVE='Y'", nativeQuery = true)
	public List<CompanySubtype> findActive();
	
	@Query(value = "select * from TBLCOMPANYSUBTYPE "
			+ "where COMPANYSUBTYPE_NAME like ?1 or COMPANYSUBTYPE_DESC like ?1 and ISACTIVE='Y'", nativeQuery = true)
	public List<CompanySubtype> findBySearch(String search);

	@Query(value = "select * from TBLCOMPANYSUBTYPE "
			+ "where COMPANYSUBTYPE_NAME like ?1 or COMPANYSUBTYPE_DESC like ?1 ", nativeQuery = true)
	public List<CompanySubtype> findAllBySearch(String search);

	@Query(value = "select * from TBLCOMPANYSUBTYPE " 
			+ "where COMPANYTYPE_ID LIKE CASE WHEN ?1 = 0 THEN COMPANYTYPE_ID ELSE ?1 END "
			+ "and ISACTIVE='Y'", nativeQuery = true)
	List<CompanySubtype> findByAdvancedSearch(Long companytypeID);
	@Query(value = "select * from TBLCOMPANYSUBTYPE " 
			+ "where COMPANYTYPE_ID LIKE CASE WHEN ?1 = 0 THEN COMPANYTYPE_ID ELSE ?1 END "
			, nativeQuery = true)
	List<CompanySubtype> findAllByAdvancedSearch(Long companytypeID);

}
