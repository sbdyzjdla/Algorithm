def solution(genres, plays):
    answer = []
    genreCnt = {}
    song = {}
    
    for i in range(len(genres)):
        if genres[i] in genreCnt:
            genreCnt[genres[i]] += plays[i]
        else:
            genreCnt[genres[i]] = plays[i]
            
    for i in range(len(genres)):
        genre = genres[i]
        play = plays[i]
        if genre in song:
            song[genre].append([play, i])
            song[genre].sort(reverse = True, key = lambda x : (x[0], -x[1]))
        else:
            song[genre] = [[play, i]]
    sdict = sorted(genreCnt.items(), key = lambda x : x[1], reverse=True) 
    
    for i in range(len(sdict)):
        songNm = sdict[i][0]
        if len(song.get(songNm)) < 2:
            answer.append(song.get(songNm)[0][1])
            continue
        else:
            answer.append(song.get(songNm)[0][1])
            answer.append(song.get(songNm)[1][1])  
                
    return answer
