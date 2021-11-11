import sys
import heapq


def main():
    # n = 정점, m = 간
    n, m = map(int, sys.stdin.readline().split())
    # k = start
    k = int(input())
    # 거리 리스트 dist[i] = 2      정점 k 부터 i 까지의 최단거리 저장
    dist = [float('inf')] * n
    dist[k-1] = 0
    graph = [[] for _ in range(m)]
    for i in range(m):
        # a -> b 까지의 w 가중 [[(1, 2), (2, 3)], [(2, 4), (3, 5)], [(3, 6)], [], [(0, 1)], []]
        # [[(1,2) , [2, 4]]]   1번 노드에서 2번노드까지 가중치 2            (a,b +1씩 해야됨)
        a, b, w = map(int, sys.stdin.readline().split())
        graph[a-1].append((b-1, w))
    heap = []
    heapq.heappush(heap, (0, k-1))
    print(graph)
    print(dist)
    while heap:
        print(heap)
        curDist, curNode = heapq.heappop(heap)
        if dist[curNode] < curDist:
            continue
        for nextNode, nextDist in graph[curNode]:
            distTemp = curDist + nextDist
            if dist[nextNode] > distTemp:
                dist[nextNode] = distTemp
                heapq.heappush(heap, (distTemp, nextNode))
    for i in dist:
        print(i if i != float('inf') else 'INF')

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()

# 첫사이클은 1 -> 2,    1 -> 2 인데 당연히 처음가는 경로니까 가중치는 초기 가중치 + 0 이 된다  'inf'가중치를 초기 가중치로 바꿔줌
# 힙에 가중치, 노드순으로 push하여 최소힙을 이용하여 가중치가 작은놈부터 불러온다(다익스트라에 우선순위 큐를 쓰는이유)
# 힙에 들어가는 노드들은 이전 정점과의 연결성이 있는 노드들만 들어가기 때문에 연결성이 없는 노드들의 dist는 그대로 inf가 된다