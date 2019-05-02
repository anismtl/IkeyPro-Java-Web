/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function changeLangue(param) {

    var val;
    val=param;
    //alert(val)
   // val1 = document.getElementById("llang").innerHTML;
   //val=document.getElementsByTagName("A")[2].innerHTML;
  //  alert(val);

         // document.getElementById("resultat").innerHTML = " ";
        var xhr = new XMLHttpRequest();
        var reponseJSON, liste;
        xhr.onreadystatechange = function () {
            console.log(this);
            if (this.readyState == 4 && this.status == 200) {

                reponseJSON = this.responseText;
               liste = JSON.parse(reponseJSON);
              //  alert(liste);

             //   s = '<a color="red"><b>' + liste + '</b></a> ';
              //  document.getElementById("resultat").innerHTML = s;
             if (liste='ok'){
              
           window.location.reload(true);
              }
            }
        }
        xhr.open("POST", "Ajax?action=L&langue=" +val, true);
        xhr.send();
   


}