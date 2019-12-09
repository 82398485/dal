package com.ctrip.framework.dal.cluster.client;

import com.ctrip.framework.dal.cluster.client.base.Listenable;
import com.ctrip.framework.dal.cluster.client.cluster.ClusterSwitchedEvent;
import com.ctrip.framework.dal.cluster.client.cluster.ClusterType;
import com.ctrip.framework.dal.cluster.client.database.Database;
import com.ctrip.framework.dal.cluster.client.database.DatabaseCategory;
import com.ctrip.framework.dal.cluster.client.sharding.context.DbShardContext;
import com.ctrip.framework.dal.cluster.client.sharding.context.TableShardContext;
import com.ctrip.framework.dal.cluster.client.sharding.idgen.ClusterIdGeneratorConfig;

import java.sql.Wrapper;
import java.util.List;
import java.util.Set;

/**
 * @author c7ch23en
 */
public interface Cluster extends Listenable<ClusterSwitchedEvent>, Wrapper {

    String getClusterName();

    ClusterType getClusterType();

    DatabaseCategory getDatabaseCategory();

    int getDbShardCount();

    Integer getDbShard(String tableName, DbShardContext context);

    boolean tableShardingEnabled(String tableName);

    String getTableShard(String tableName, TableShardContext context);

    Set<String> getAllTableShards(String tableName);

    String getTableShardSeparator(String tableName);

    List<Database> getDatabases();

    Database getMasterOnShard(int shardIndex);

    List<Database> getSlavesOnShard(int shardIndex);

    ClusterIdGeneratorConfig getIdGeneratorConfig();

}
