import heapq

# 작업의 소요시간이 적을수록 평균치가 낮다 
# 해당시간에 작업을 할수 있는 작업들중 소요시간이 적게 드는거부터 작업시작
# 작업이 끝난후 pop
    
def solution(jobs):
    answer, start, now = 0, -1, 0
    i = 0
    heap = []
    while i < len(jobs):
        for job in jobs:
            if start < job[0] <= now:
                heapq.heappush(heap, [job[1], job[0]])        
        if len(heap) > 0:
            cjob = heapq.heappop(heap)
            start = now
            now += cjob[0]
            answer += (now - cjob[1])
            i +=1
        else:
            now +=1
        
    return answer // len(jobs)