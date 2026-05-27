-- 코드를 작성해주세요

select sum(price) as total_price from ITEM_INFO
group by rarity
having rarity = 'legend'