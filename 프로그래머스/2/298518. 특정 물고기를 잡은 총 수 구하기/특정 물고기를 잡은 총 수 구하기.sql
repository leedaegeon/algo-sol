SELECT count(fi.id) FISH_COUNT
from FISH_INFO as fi
    join FISH_NAME_INFO as fn
    on fi.fish_type = fn.fish_type
 where fn.fish_name = 'BASS' or fn.fish_name = 'snapper'