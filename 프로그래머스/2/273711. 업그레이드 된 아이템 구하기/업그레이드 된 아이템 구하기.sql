select info.item_id, info.item_name, info.rarity
from item_info info
where item_id in (select t.item_id
        from item_info i join item_tree t
        on i.item_id = t.parent_item_id
        where i.rarity = 'rare')
order by 1 DESC
