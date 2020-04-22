<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 4/21/20
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%-- jQuery --%>
<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<%-- Bootstrap --%>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script>

    // Function that will change settings once nav reaches top of scree
    function fixNav() {
        if (window.scrollY >= topOfNav) {
            document.body.style.paddingTop = (nav.offsetHeight) + 'px';
            document.body.classList.add('fixed-nav');
        } else {
            document.body.classList.remove('fixed-nav');
            document.body.style.paddingTop = 0;
        }
    }

</script>