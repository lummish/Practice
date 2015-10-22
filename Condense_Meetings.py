

def condense_meeting_times( times_array ):
	
	sorted_times = sorted( times_array, key = lambda x: x[0])

	condensed = [sorted_times[0]]
	
	for time in sorted_times[1:]:
		overlap ( condensed, time, condensed[-1] )

	return condensed


def overlap( ar, t_a, t_b ):
	
	if ( len(ar) == 0 ):
		ar.append(t_a)

	if ( t_a[0] >= t_b[0] and t_a[0] <= t_b[1] ):
		ar[-1] = ( t_b[0], t_a[1] )

	elif ( t_a[1] >= t_b[0] and t_a[1] <= t_b[1] ):
		ar[-1] = ( t_a[0], t_b[1] )

	else:
		ar.append(t_a)


print condense_meeting_times([(0,1), (3,5), (4,8), (10,12), (9,10)])