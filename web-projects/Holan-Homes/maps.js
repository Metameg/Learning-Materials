// Initialize and add the map
function initMap() {
  // The location of Houston
  const houston = { lat: 29.74894429551707, lng:  -95.36149994966885 };

    // The map, centered at Houston
  const map = new google.maps.Map(document.getElementById("map"), {
    zoom: 11,
    center: houston,
  });

  //The locations of each address
  const homes = [
    [{ lat: 29.73011978569972, lng:  -95.32402021982838 }, "5210 Claremont St."],
    [{ lat: 29.719452404647498, lng:  -95.37253795981026}, "2610 Southmoore Blvd."],
    [{ lat: 29.77971465821917, lng:  -95.36258081563102 }, "2119 Freeman St."],
    [{ lat: 29.799821184744562, lng:  -95.38335920028814}, "111 Harris Ct."],
    [{ lat: 29.79970446625314, lng:  -95.38343483097327 }, "109 Harris Ct."],
    [{ lat: 29.7803387568841, lng:  -95.35720647330231 }, "2017 Marrion St."]
  ];

  const infoWindow = new google.maps.InfoWindow();
  /*const claremont = { lat: 29.73011978569972, lng:  -95.32402021982838 };
  const freeman = { lat: 29.73011978569972, lng:  -95.32402021982838 };
  const southmore = { lat: 29.719452404647498, lng:  -95.37253795981026};
  const harris111 = { lat: 29.799821184744562, lng:  -95.38335920028814};
  const harris109 = { lat: 29.79970446625314, lng:  -95.38343483097327 };
  const marrion = { lat: 29.7803387568841, lng:  -95.35720647330231 };*/


  // The markers, positioned at each location's address
  homes.forEach(([position, title], i) => {
    const marker = new google.maps.Marker({
      position,
      map,
      title: `${title}`,
      optimized: false,
    });
    // Add a click listener for each marker, and set up the info window.
    marker.addListener("click", () => {
      infoWindow.close();
      infoWindow.setContent(marker.getTitle());
      infoWindow.open(marker.getMap(), marker);
    });
  });
}
