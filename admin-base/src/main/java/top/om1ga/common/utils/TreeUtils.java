package top.om1ga.common.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月21日 10:26
 * @Description:
 * @since: 1.0
 */
public class TreeUtils {

    public static <T extends TreeNode<T>> List<T> build(List<T> treeNodes){
        List<T> result = new ArrayList<>();

//        list转map
        Map<Long,T> nodeMap = new LinkedHashMap<>(treeNodes.size());
        for (T treeNode :
                treeNodes) {
            nodeMap.put(treeNode.getPid(), treeNode);
        }

        for (T node :
                nodeMap.values()) {
            T parent = nodeMap.get(node.getPid());
            if (parent != null && !(node.getId().equals(parent.getId()))){
                parent.getChildren().add(node);
                continue;
            }
            result.add(node);
        }
        return result;
    }

    /**
     * 根据pid，构建树节点
     * @param treeNodes
     * @param pid
     * @return
     * @param <T>
     */

    public static <T extends TreeNode<T>> List<T> build(List<T> treeNodes, Long pid){
//        pid不能为空
        AssertUtils.isNull(pid,"pid");

        List<T> treeList= new ArrayList<>();
        for (T treeNode :
                treeNodes) {
            if (pid.equals(treeNode.getPid())) {
                treeList.add(findChildren(treeNodes, treeNode));
            }
        }
        return treeList;
    }

    /**
     * 查找子节点
     * @param treeNodes
     * @param rootNode
     * @return
     * @param <T>
     */
    private static <T extends TreeNode<T>> T findChildren(List<T> treeNodes,T rootNode){
        for (T treeNode:treeNodes
             ) {
            if (rootNode.getId().equals(treeNode.getPid())){
                rootNode.getChildren().add(findChildren(treeNodes,treeNode));
            }
        }
        return rootNode;
    }
}
