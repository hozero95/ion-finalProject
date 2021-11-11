package com.example.finalProject.respository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.domain.entity.UsersVO;

@Repository
public interface UsersRepository extends JpaRepository<UsersVO, Long> {
	public List<UsersVO> findAll(Sort sort);

	@Transactional
	public Long deleteByUserUnum(Long userUnum);

	// userId를 기준으로 User 정보를 가져올 때 권한 정보도 같이 가져옴
	@EntityGraph(attributePaths = "authorities")
	Optional<UsersVO> findOneWithAuthoritiesByUserId(String userId);

	public Boolean existsByUserId(String userId);
	
	public List<UsersVO> findByUserId(String userId);
}
