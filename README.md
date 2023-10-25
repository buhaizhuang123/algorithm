# algorithm

```
十大经典排序算法(JAVA代码实现)
  1. 冒泡排序 Bubble
  2. 选择排序 Select
  3. 插入排序 Insert
  4. 希尔排序 Shell 减小增量排序
  5. 归并排序 Merger
  6. 堆排序 Heap
  7. 桶排序 Bucket
  8. 计数排序 Counter
  9. 基数排序 Cardinal
  10. 快速排序 Fast
图算法
  1. dijkstra 算法 (最短路径)
    1.1 步骤
        1.1.1 开始节点 start  = 0
        1.1.2 min =  最小节点 (第一次循环必然是开始节点,不能是被访问节点)
        1.1.3 visited[min] = true,防止1.1.2 步骤重复筛选
            if 剩余节点权重值 > 父节点值 + 图中当前节点边的值
                剩余节点权重值 = 父节点值 + 图中当前节点边的值
        经过首次遍历后: 开始节点所关联子节点全部被发现. 继续1.1.2 步骤
        
        
  2. prim 算法 普雷姆 (最小生成树)
    2.1 步骤
        普雷姆算法,贪婪算法的一种,找最小的那条边.边涉及的节点不能形成环,不能重复访问 
        (代码实现方式相对于迪克斯特拉少了计算父节点值的步骤)
    
  3. bellmanFord 贝尔曼福德 最短路径算法
  4. floyd 弗洛伊德算法 最短路径算法
    4.1 floyd 算法. 找每个节点,作为中间节点的记录. 若是 k 关联的 i,k + k,j < i,j 
        那么 i,j 最短路径需要k节点关联
  5. kruskal 克鲁斯卡尔算法 最小生成树算法
    5.1 kruskal 算法 , 节点全部排序,由小到大. 
        由小到大遍历. 节点的顶点不能相同(不能构成环),类似于不能被访问
        
