def call(Map config=[:]) {
  def rawBody = libraryResource 'com/planetpope/api/jira/createIssue.json'
  def binding = [
    key: "${config.key}",
    summary: "${config.summary}",
    description: "${config.description}",
    issueTypeName: "${config.issueTypeName}"
  ]
  def render = renderTemplate(rawBody,binding)
  bat('curl -D- -u $JIRA_CREDENTIALS -X POST --data "'{\"fields\":{\"project\":{\"key\": \"DEP\"},\"summary\":\"Issue created from Jenkins\",\"description\":\"Tests failed here is the report:http://localhost:8080/job/ecommerce_website_testing/allure\",\"issuetype\": {\"name\": \"Bug\"}}}'" -H "Content-Type: application/json" https://testecom.atlassian.net/rest/api/2/issue/')
}
