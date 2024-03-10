-- 코드를 입력하세요
SELECT f.flavor FLAVOR
from first_half as f
order by f.total_order DESC, f.shipment_id ASC
