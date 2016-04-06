package com.ctrip.apollo.biz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.ctrip.apollo.biz.entity.Release;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
public interface ReleaseRepository extends PagingAndSortingRepository<Release, Long> {

  @Query("SELECT r FROM Release r WHERE r.appId = :appId AND r.clusterName = :clusterName AND r.namespaceName = :namespaceName order by r.id desc")
  Release findLatest(@Param("appId") String appId, @Param("clusterName") String clusterName,
      @Param("namespaceName") String namespaceName);

  List<Release> findByAppIdAndClusterNameAndNamespaceName(String appId, String clusterName,
      String namespaceName);
}
