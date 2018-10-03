<%@ taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<compress:html>
    <%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib  prefix="form"   uri="http://www.springframework.org/tags/form" %>
    <%@taglib  prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <%@include file='/WEB-INF/template/template_variables.jspf' %>
    <html lang="${lang}">
        <%@include file='/WEB-INF/template/head.jspf' %>
        <body id="contrast-finder-page">
            <div class="container">

                <%-- ===== HEADER ========================================================================================= --%>
                <%@include file='/WEB-INF/template/header.jspf' %>


                <%-- ===== CONTENT ========================================================================================= --%>
                <div class="help">
                    <h1><fmt:message key="page.about.title"/></h1>

<%-- TEST language code is not available --%>
<c:set var="isAvalaibleLanguage" value="false"     scope="page" />
<c:forEach var="langCode" items="${orderedLanguagesList}">
    <c:choose>
        <c:when test="${lang == langCode}">
            <c:set var="isAvalaibleLanguage" value="true" scope="page" />
        </c:when>
    </c:choose>
</c:forEach>
<c:choose>
    <c:when test="${isAvalaibleLanguage == 'false'}">
        <%-- <hr>NOT avalaible language <hr> --%>
        <%-- <c:redirect url="/?lang=${defaultLanguage}"/>--%>
        <%--        <%
                response.setStatus(301);
                response.setHeader( "Location", "./?lang=en" );
                response.setHeader( "Connection", "close" );
                %> --%>
    </c:when>
</c:choose>



                    <h2><fmt:message key="page.about.availableLanguages"/></h2>
                    <ul>
                        <c:forEach var="langCode" items="${orderedLanguagesList}">
                            <li lang="${langCode}">
                                <a hreflang="${langCode}"
                                   title="Contrast-Finder in english"
                                   href="./?lang=${langCode}">${langCode} - ${fn:toLowerCase(availableLanguages[langCode])}</a>
                            </li>
                        </c:forEach>
                    </ul>
                        <%--    <c:forEach var="langCode" items="${orderedLanguagesList}">
                                    ${langCode} - ${availableLanguages[langCode]} <br>
                                </c:forEach>  <hr> --%>
                        <%--    <c:forEach items="${availableLanguages}" var="entry">
                                    ${entry.key} - ${entry.value}   <br>
                                </c:forEach>  <hr> --%>



                    <%  //Get version of application
                        java.util.Properties prop = new java.util.Properties();
                        prop.load(getServletContext().getResourceAsStream("/META-INF/MANIFEST.MF"));
                        String appliVersion    = prop.getProperty("Build-Release");
                        String appliBuildID    = prop.getProperty("Build-Id");
                        String appliBuildDate  = prop.getProperty("Build-Date");
                        String appliBuildMaven = prop.getProperty("Maven-Version");
                        String appliBuildJava  = prop.getProperty("Java-Version");
                        String appliBuildOs    = prop.getProperty("Os-Name");
                        String appliBuildArch  = prop.getProperty("Os-Arch");
                        String gitCommit       = prop.getProperty("git-commit");
                        String gitBranch       = prop.getProperty("git-branch");
                        String gitURL          = prop.getProperty("git-url");
                    %>
                        <%--    version:    <%=appliVersion%>       <br>
                                git commit: <%=gitCommit%>          <br>
                                git branch: <%=gitBranch%>          <br>
                                git URL:    <%=gitURL%>             <br>
                                Build ID:   <%=appliBuildID%>       <br>
                                Build date: <%=appliBuildDate%>     <br>
                                Build :     <%=appliBuildMaven%>    <br>
                                Build :     <%=appliBuildJava%>     <br>
                                Build :     <%=appliBuildOs%>       <br>
                                Build :     <%=appliBuildArch%>     <br>    --%>

                    <h2><fmt:message key="page.about.build.title"/></h2>
                    <ul>
                        <li>version: <strong><%=appliVersion%></strong> </li>
                        <li>git branch: <%=gitBranch%>     </li>
                        <li>git commit: <a href="<%=gitURL%>"><%=gitCommit%></a> </li>
                        <li>Build:
                            <ul>
                                <li>date: <%=appliBuildDate%> </li>
                                <li>ID: <%=appliBuildID%> </li>
                                <li>Platform: <%=appliBuildOs%> <%=appliBuildArch%>,
                                              Java <%=appliBuildJava%>,
                                              Maven <strong><%=appliBuildMaven%></strong>
                                </li>
                            </ul>
                        </li>
                    </ul>

                    <h2><fmt:message key="page.about.fileList.title"/></h2>
                    <ul>
                        <li><a href="contribute.json">contribute.json</a> </li>
                        <li><a href="humans.txt">humans.txt</a> </li>
                        <li><a href="robots.txt">robots.txt</a> </li>
                        <li><a href=".well-known/security.txt">security.txt</a> </li>
                    </ul>

                </div>
            </div>  <!-- class="container' -->


            <%-- ===== FOOTER ========================================================================================= --%>
            <%@include file='/WEB-INF/template/footer.jspf' %>
        </body>
    </html>
</compress:html>
