import heapq

def solution(scoville, K):
    answer = 0
    hq = []
    for i in scoville:
        heapq.heappush(hq, i)
        
    while hq:
        if hq[0] >= K:
            break
        sv1 = heapq.heappop(hq)
        if sv1 < K:
            sv2 = heapq.heappop(hq)
            heapq.heappush(hq, sv1 + (sv2 * 2))
            answer += 1
        if hq[0] >= K:
            break
        if len(hq) < 2:
            answer = -1
            break
            
    
    return answer