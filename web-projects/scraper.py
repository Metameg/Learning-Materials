import requests
from bs4 import BeautifulSoup
import pandas as pd
import re

# f = open('myfile','w')
page = requests.get("https://www.houston-neighborhoods.com/search/results/?county=all&city=all&market_area=Bellaire+Area&subdivision=all&type=res&type=con&type=lnd&type=mul&list_price_min=250000&list_price_max=all&sort_latest=true&agent_id=16156")
soup = BeautifulSoup(page.content, "html.parser")



property_tags = soup.select(".address")
properties = [a.get_text() for a in property_tags]

for p in properties:
    p = re.sub('\t', '', p)
price_tags = soup.select(".price")
prices = [p.get_text() for p in price_tags]

property = pd.DataFrame({
"Properties" : properties,
"Price" : prices
})

property["Properties"] = property["Properties"].str.strip()

property["Price"] = property["Price"].str.strip()


print(property)
