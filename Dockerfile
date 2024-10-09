# Use the WildFly base image
FROM jboss/wildfly:latest

# Copy the WAR file into the deployments directory
COPY target/*.war /opt/jboss/wildfly/standalone/deployments/

# Expose the default WildFly port
EXPOSE 8080

# Set the default command to run WildFly in standalone mode
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone.xml"]
